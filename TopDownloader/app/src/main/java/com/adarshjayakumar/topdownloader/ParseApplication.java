package com.adarshjayakumar.topdownloader;

import android.util.Log;
import android.widget.ArrayAdapter;

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

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public boolean process ()
    {
        boolean status = true;
        Application currentRecord = null;
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
           //             Log.d("Parse Application","The starting tag is "+tagName);
                        if(tagName.equalsIgnoreCase("entry"))
                        {
                            inEntry = true;
                            currentRecord = new Application();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
         //               Log.d("Parse Application","Ending tag for "+tagName);
                        if(inEntry){
                            if(tagName.equalsIgnoreCase("entry"))
                            {
                                applications.add(currentRecord);
                                inEntry = false;
                            }
                            else if(tagName.equalsIgnoreCase("name"))
                            {
                                currentRecord.setTitle(textValue);
                            }
                            else if(tagName.equalsIgnoreCase("artist"))
                            {
                                currentRecord.setArtist(textValue);
                            }
                            else if(tagName.equalsIgnoreCase("releasedate"))
                            {
                                currentRecord.setReleaseDate(textValue);
                            }
                        }
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
       /* for(Application app : applications)
        {
            Log.d("Parse Application :"," Title :"+app.getTitle()+ " Artist : "+app.getArtist()+" Release Date : "+app.getReleaseDate());
        }*/
        return true;
    }
}
