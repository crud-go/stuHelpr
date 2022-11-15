package com.ujs.stupool.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TokenUtil {
    public static String[] my_items;
    public static String secret ="qwqhhhzzzxsd";
    private final static int maxtime=60*60*24*5;


    public static String GenerateToken(String username,int id){
        long seconds=System.currentTimeMillis()/1000;
        seconds+= maxtime;
        String timestamp= String.valueOf(seconds);
        String builder = secret +
                "-" +
                id +
                "-" +
                username +
                "-" +
                timestamp;
        return Base64.getEncoder().encodeToString(builder.getBytes(StandardCharsets.UTF_8));

    }
    public static boolean isTokenValid(String s_token ){
        if(s_token==null)return  false;
        String token= new String(Base64.getDecoder().decode(s_token));
        if(token.contains(secret))
        {
            try{
                String[] items=  token.split("-");
                if(items.length!=4)return  false;
                my_items=items;
                long ValidTime=Long.parseLong(items[3]);
                long NowStamp=System.currentTimeMillis()/1000;
                return NowStamp < ValidTime;

            }catch (Exception e){
                e.printStackTrace();
                return  false;

            }

        }else{

            return false;
        }



    }

    public  static  String getUsernameFromToken(String token)
    {

        return my_items[2];

    }
    public  static  int getUserIdFromToken(String token)
    {

        return Integer.parseInt(my_items[1]);
    }

}
