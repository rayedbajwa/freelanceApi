package com.letme.Utility;

/**
 * Created by mbajwa11 on 1/3/17.
 */

import com.letme.Tasks.controller.TasksController;
import com.letme.Tasks.entity.Tasks;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Utility class for converting JSON to Entities
 */

public class Mapper{

    private Tasks finalObj;
    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Mapper.class);
    public Tasks convertJsontoTask(HashMap<String, String> temp)throws
            IllegalAccessException,
            IllegalArgumentException, ParseException{
        finalObj = new Tasks(
                temp.get("name"),
                Integer.parseInt(temp.get("type_id")),
                temp.get("desc"),
                formatter.parse(temp.get("created_date")),
                formatter.parse(temp.get("expire_date")),
                Integer.parseInt(temp.get("budget")),
                temp.get("street_add"),
                Integer.parseInt(temp.get("city_id")),
                Integer.parseInt(temp.get("country_id")),
                Integer.parseInt(temp.get("zip")),
                Integer.parseInt(temp.get("status")),
                Boolean.parseBoolean(temp.get("active"))
        );
        return finalObj;
    }
}
