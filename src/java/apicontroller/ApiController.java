/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apicontroller;

/**
 *
 * @author anapat
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import model.Fault;
import model.FossilSite;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiController {
    public static void main(String args[]){
//        System.out.println("HTTP Request Example ");
        //Making Get Request
        //sendGetRequest();
        //Making Post Request
        //sendPOSTRequest();
        //Parse Json Reponse
        FaultAPI();
        FossilSiteAPI();
    }

    public static List<Fault> FaultAPI(){
        List<Fault> faultList = new ArrayList<Fault>();
        System.out.print("hi1");
        try {
            URL url = new URL("https://opend.data.go.th/get-ckan/datastore_search?resource_id=995cf9e6-cd38-4e32-afda-039301e562b0");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            //adding header
            httpURLConnection.setRequestProperty("api-key","hoIxlJfmbZ2H7lG3GVIK1JaE1c3U4BBs");
            
            String line="";
            InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuilder response=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                response.append(line);
            }
            bufferedReader.close();
//            System.out.println("Response : "+response.toString());
            
            JSONObject jsonObject =new JSONObject(response.toString());
            System.out.println("Fault API Records : "+jsonObject.getJSONObject("result").getJSONArray("records").length());
            for (int i=0;i<jsonObject.getJSONObject("result").getJSONArray("records").length();i++){ 
                String faultName = jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("F_NAME_T").toString();
//                System.out.print(faultName);
                String typeOfFault = jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("SENSE_OF_F").toString();
                String fault_length = jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("LENGTH_KM").toString()+" KM";
                Fault fault = new Fault(i,faultName,typeOfFault,fault_length);
                faultList.add(fault);
//                System.out.println(i);
//                System.out.println("Fault Name : "+jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("F_NAME_T"));
//                System.out.println("Type of Fault : "+jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("SENSE_OF_F"));
//                System.out.println("Length of Fault : "+jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("LENGTH_KM")+" KM");
//                System.out.println();
            }

        }
        catch (Exception e){
            System.out.println("Error in Making Get Request");
        }
        System.out.println();
        System.out.print(faultList);
        return faultList;
    }
    public static List<FossilSite> FossilSiteAPI(){
        List<FossilSite> fossilSiteList = new ArrayList<FossilSite>();
        try {
            URL url = new URL("https://opend.data.go.th/get-ckan/datastore_search?resource_id=6fe4dbba-78be-4567-844c-5e8fc75b20a9&");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            //adding header
            httpURLConnection.setRequestProperty("api-key","hoIxlJfmbZ2H7lG3GVIK1JaE1c3U4BBs");
            
            String line="";
            InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuilder response=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                response.append(line);
            }
            bufferedReader.close();
//            System.out.println("Response : "+response.toString());
            JSONObject jsonObject =new JSONObject(response.toString());
            System.out.println("Fault API Records : "+jsonObject.getJSONObject("result").getJSONArray("records").length());
            for (int i=0;i<jsonObject.getJSONObject("result").getJSONArray("records").length();i++){
                String siteName = jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("SITE_NAME_THAI").toString();
                String localName = jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("LOCALITY_THAI").toString();
                String localAddress = jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("OTHER_DISTRICT").toString()+" "
                        +jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("OTHER_CITY").toString()+" "
                        +jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("OTHER_PROVINCE").toString();
                
                FossilSite fossilSite = new FossilSite(i,siteName,localName,localAddress);
                fossilSiteList.add(fossilSite);
//                System.out.println(i);
//                System.out.println("Site Name : "+jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("SITE_NAME_THAI"));
//                System.out.println("Local Name: "+jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("LOCALITY_THAI"));
//                System.out.println("Local Address : "
//                        +jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("OTHER_DISTRICT")+" "
//                        +jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("OTHER_CITY")+" "
//                        +jsonObject.getJSONObject("result").getJSONArray("records").optJSONObject(i).get("OTHER_PROVINCE"));
//                System.out.println();
            }

        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Error in Making Get Request");
        }
        System.out.println();
        System.out.print(fossilSiteList);
        return fossilSiteList;
    }
    
}
