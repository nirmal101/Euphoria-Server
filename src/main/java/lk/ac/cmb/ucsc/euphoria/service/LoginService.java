package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.repository.LoginCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    LoginCredentialRepository loginCredentialRepository;

    @Autowired
    CounselorRepository counselorRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<LoginCredentials> credentials=loginCredentialRepository.findByUsername(s);

        credentials.orElseThrow(() -> new UsernameNotFoundException("Username "+s+" is not found"));

        LoginCredentials credential = credentials.get();

        Optional<Counselor> counselor = counselorRepository.findByLoginCredentials(credential);
        if (!counselor.isEmpty())
            credential.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_COUNSELOR")));

        return credential;
    }



}
