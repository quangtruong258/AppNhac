package com.example.appnhac.Service;

public class APIService {
    private  static String url = "https://musicbasicapp.000webhostapp.com/Server/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(url).create(DataService.class);
    }


}
