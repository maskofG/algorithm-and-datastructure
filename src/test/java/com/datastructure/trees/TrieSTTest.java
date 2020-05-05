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
    public void setUp() {
        trieST = new TrieST<>();
    }

    @Test
    public void testPut(){

        LatLong latLong1 = new LatLong(12.12f, 23.23f);
        LatLong latLong2 = new LatLong(12.56f, 44.44f);
        trieST.put("sa",  latLong1);
        trieST.put("mk", latLong2);

        Assert.assertEquals(latLong1, trieST.get("sa"));
        Assert.assertEquals(latLong2, trieST.get("mk"));
        Assert.assertEquals(null, trieST.get("mka"));
        Assert.assertEquals(null, trieST.get("saa"));
        Assert.assertEquals(null, trieST.get("s"));
        Assert.assertEquals(null, trieST.get("m"));
    }

    @Test
    public void testDelete(){
        LatLong latLong1 = new LatLong(12.12f, 23.23f);
        LatLong latLong2 = new LatLong(12.56f, 44.44f);
        trieST.put("sa",  latLong1);
        trieST.put("mk", latLong2);

        Assert.assertEquals(latLong1, trieST.get("sa"));
        trieST.delete("s");
        trieST.delete("sk");
        trieST.delete("sak");
        trieST.delete("sa?");
        trieST.delete("s*");
        Assert.assertEquals(latLong1, trieST.get("sa"));

        Assert.assertEquals(latLong2, trieST.get("mk"));
        trieST.delete("m");
        trieST.delete("ma");
        trieST.delete("mkk");
        trieST.delete("mk?");
        trieST.delete("m*");
        Assert.assertEquals(latLong2, trieST.get("mk"));

        Assert.assertEquals(latLong1, trieST.get("sa"));
        trieST.delete("sa");
        Assert.assertEquals(null, trieST.get("sa"));

        Assert.assertEquals(latLong2, trieST.get("mk"));
        trieST.delete("mk");
        Assert.assertEquals(null, trieST.get("mk"));

    }
}
