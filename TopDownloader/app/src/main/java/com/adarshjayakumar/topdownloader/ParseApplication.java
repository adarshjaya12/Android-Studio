package com.adarshjayakumar.topdownloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by adarsh on 3/16/2016.
 */
public class ParseApplication {
    private String xmlData;
    private ArrayList<Application> applications;

    public ParseApplication(String xmlData) {
        this.xmlData = xmlData;
        applications = new ArrayList<>();
    }

    public boolean process ()
    {
        boolean status = true;
        Application currentRecord;
        boolean inEntry = false;
        String textValue ="";

        try
        {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType)
                {
                    case XmlPullParser.START_TAG:
                        Log.d("Parse Application","The starting tag is "+tagName);
                        if(tagName.equalsIgnoreCase("entry"))
                        {
                            inEntry = true;
                            currentRecord = new Application();
                        }
                    case XmlPullParser.END_TAG:
                        Log.d("Parse Application","Ending tag for "+tagName);
                        break;
                    default:
                        //nothing
                }
                 eventType = xpp.next();
            }

        }
        catch (Exception e)
        {
            status=false;
            e.printStackTrace();
        }
        return true;
    }
}
