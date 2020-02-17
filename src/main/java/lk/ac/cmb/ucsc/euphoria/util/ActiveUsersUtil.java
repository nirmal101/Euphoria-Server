package lk.ac.cmb.ucsc.euphoria.util;

import java.util.ArrayList;
import java.util.List;


public class ActiveUsersUtil {
    private List<String> store;

    public ActiveUsersUtil() {
        this.store = new ArrayList<>();
    }

    public List<String> getStore() {
        return store;
    }

    public void add(String username){
        store.add(username);
    }
}
