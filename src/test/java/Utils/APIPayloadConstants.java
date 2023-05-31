package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    // we will pass the body in multiple formats, for this we have created this class

    public static String createEmployeePayload(){

        String createEmployeePayload="{\n" +
                "    \"emp_firstname\": \"andyc\",\n" +
                "    \"emp_lastname\": \"wilson\",\n" +
                "    \"emp_middle_name\": \"ms\",\n" +
                "    \"emp_gender\": \"F\",\n" +
                "    \"emp_birthday\": \"1992-05-20\",\n" +
                "    \"emp_status\": \"Confirmed\",\n" +
                "    \"emp_job_title\": \"Engineer\"\n" +
                "}";

        return createEmployeePayload;

    }

    public static  String createEmployeePayloadJson(){


        // hardcoded values-data as andyc,wilson ..
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname","andyc");
        obj.put("emp_lastname","wilson");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","1992-05-20");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","Engineer");
        return obj.toString();

    }

    public static  String createEmployeePayloadDynamic(String emp_firstname,String emp_lastname,
                                                      String emp_middle_name, String emp_gender,
                                                       String emp_birthday, String emp_status,
                                                       String emp_job_title){

        JSONObject obj=new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);

        return obj.toString();

    }

    public static  String updateEmployeePayloadJson(){


        JSONObject obj=new JSONObject();
        obj.put("employee_id","53522A");
        obj.put("emp_firstname","andrea");
        obj.put("emp_lastname","gligorijevic");
        obj.put("emp_middle_name","candy");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2000-07-24");
        obj.put("emp_status","probation");
        obj.put("emp_job_title","SDET");
        return obj.toString();

    }




}
