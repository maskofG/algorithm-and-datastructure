package com.datastructure.trees;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieSTTest {

    private TrieST<LatLong> trieST;

    class LatLong {
        public float lat;
        public float lon;

        public LatLong(float lat, float lon){
            this.lat = lat;
            this.lon = lon;
        }
    }

    @Before
    public void setup() {
        trieST = new TrieST<>();
    }

    @Test
    public void testput(){

        LatLong latLong1 = new LatLong(12.12f, 23.23f);
        LatLong latLong2 = new LatLong(12.56f, 44.44f);
        trieST.put("sa",  latLong1);
        trieST.put("mk", latLong2);

        Assert.assertEquals(trieST.get("sa"), latLong1);
        Assert.assertEquals(trieST.get("mk"), latLong2);
        Assert.assertEquals(trieST.get("mka"), null);
        Assert.assertEquals(trieST.get("saa"), null);
        Assert.assertEquals(trieST.get("s"), null);
        Assert.assertEquals(trieST.get("m"), null);
    }
}
