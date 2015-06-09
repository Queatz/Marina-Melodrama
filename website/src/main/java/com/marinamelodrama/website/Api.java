package com.marinamelodrama.website;

import javax.servlet.http.HttpServletRequest;

import com.marinamelodrama.website.api.EmailRecord;
import static com.marinamelodrama.website.api.OfyService.ofy;

/**
 * Created by Jacob on 5/16/15.
 */
public class Api {
    public static String get(HttpServletRequest req) {
        return null;
    }

    public static String post(HttpServletRequest req) {
        String[] path = req.getRequestURI().split("/");

        switch(path[2]) {
            case "keep-in-touch":
                return keepInTouch(req.getParameter("email"));
        }

        return null;
    }

    public static String keepInTouch(String email) {
        if(email == null)
            return "hmm";

        EmailRecord record = ofy().load().type(EmailRecord.class).filter("email", email).first().now();

        if(record != null)
            return "already";

        record = new EmailRecord();

        record.setEmail(email);
        ofy().save().entity(record).now();

        return "sure";
    }
}
