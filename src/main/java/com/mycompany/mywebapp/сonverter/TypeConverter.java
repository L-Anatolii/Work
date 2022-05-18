package com.mycompany.mywebapp.сonverter;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@Component
public class TypeConverter {

    public static JobPositions StringToEnam(String dto) {
        for(JobPositions e : JobPositions.values()){
            if(e.getName().equals(dto)){
                return e;
            }
        }
        //Поправить сообщение
        throw new IllegalArgumentException("No enum found with job position "+dto);
    }

    public static String enamToString(JobPositions jobPositions) {
        for(JobPositions e : JobPositions.values()){
            if(e.equals(jobPositions)){
                return e.getName();
            }
        }
        //Поправить сообщение
        throw new IllegalArgumentException("No job position found with "+jobPositions.getName());
    }


    public String dateToString(Date date){
        SimpleDateFormat pattern = new SimpleDateFormat("dd.MM.yyyy");
        return pattern.format(date.getTime());

    }

    public Date stringToDate(String dto)  {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = formatter.parse(dto);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}