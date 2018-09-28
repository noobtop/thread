package com.noob.top.FalseDemo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AboutCopy
{
    private final ConcurrentHashMap<String, Point> map ;
    private final Map<String, Point> unmap ;
    private final Map<String, Point> samap ;

    public  AboutCopy(ConcurrentHashMap<String, Point> map)
    {
        this.map = map;
        this.unmap = Collections.unmodifiableMap(this.map);
        this.samap = Collections.unmodifiableMap(new HashMap<String,Point>(map));
    }


    public Map<String,Point> getCopy1Locations()
    {
        return this.unmap;
    }

    public Map<String,Point> getCopy2Locations()
    {
        return this.samap;
    }

    public static void main(String[] args)
    {
        ConcurrentHashMap<String,Point> ccmap = new ConcurrentHashMap<>();
        ccmap.put("a",new Point(1,1));
        ccmap.put("b",new Point(2,2));
        ccmap.put("c",new Point(3,3));

        AboutCopy ac = new AboutCopy(ccmap);
        ccmap.replace("b",new Point(4,4));
        System.out.println("deep:" + ac.getCopy1Locations().toString());
        System.out.println("shallow:" + ac.getCopy2Locations().toString());

    }

}

class Point
{
    public final int x;

    public final int y;

    public  Point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString()
    {
        return "{x:" + x + ",y:" + y + "}";
    }
}

