package lk.ac.cmb.ucsc.euphoria.controller.common;

import io.jsonwebtoken.Jws;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.service.CounselorService;
import lk.ac.cmb.ucsc.euphoria.service.LoginService;
import lk.ac.cmb.ucsc.euphoria.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RequestMapping("authenticate")
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginCredentials credentials) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Invalid username or password",e);
        }

        final UserDetails userDetails = loginService.loadUserByUsername(credentials.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        Map<String,String> jwtMap=new HashMap<>(1);
        jwtMap.put("jwt",jwt);

        return ResponseEntity.ok(jwtMap);
    }
}
