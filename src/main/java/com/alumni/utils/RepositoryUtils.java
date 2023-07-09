package com.alumni.utils;

import java.util.Objects;
import java.util.Optional;

public class RepositoryUtils {

    public static String searchFormatter(String s){
        return s.equals("") ?s:"%"+s+"%";
    }
}
