package com.datastructure.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TernarySearchTrieSTTest {

    private TernarySearchTrieST<LatLong> ternaryTrie;

    class LatLong {
        public float lat;
        public float lon;

        public LatLong(float lat, float lon){
            this.lat = lat;
            this.lon = lon;
        }
    }


    @Before
    public void setUp(){
        ternaryTrie = new TernarySearchTrieST<>();
    }

    @Test
    public void testPut(){
        LatLong latLong1 = new LatLong(12.12f, 23.23f);
        LatLong latLong2 = new LatLong(12.56f, 44.44f);
        ternaryTrie.put("sa",  latLong1);
        ternaryTrie.put("mk", latLong2);
        ternaryTrie.put("sbk", latLong1);
        ternaryTrie.put("mak", latLong2);

        Assert.assertEquals(latLong1, ternaryTrie.get("sa"));
        Assert.assertEquals(latLong2, ternaryTrie.get("mk"));
        Assert.assertEquals(latLong1, ternaryTrie.get("sbk"));
        Assert.assertEquals(latLong2, ternaryTrie.get("mak"));
        Assert.assertEquals(null, ternaryTrie.get("mka"));
        Assert.assertEquals(null, ternaryTrie.get("saa"));
        Assert.assertEquals(null, ternaryTrie.get("s"));
        Assert.assertEquals(null, ternaryTrie.get("sb"));
        Assert.assertEquals(null, ternaryTrie.get("sbka"));
        Assert.assertEquals(null, ternaryTrie.get("m"));
        Assert.assertEquals(null, ternaryTrie.get("ma"));
        Assert.assertEquals(null, ternaryTrie.get("maka"));
    }

    @Test
    public void testDelete(){
        LatLong latLong1 = new LatLong(12.12f, 23.23f);
        LatLong latLong2 = new LatLong(12.56f, 44.44f);
        ternaryTrie.put("sa",  latLong1);
        ternaryTrie.put("mk", latLong2);

        Assert.assertEquals(latLong1, ternaryTrie.get("sa"));
        ternaryTrie.delete("sa");
        Assert.assertEquals(null, ternaryTrie.get("sa"));

        Assert.assertEquals(latLong2, ternaryTrie.get("mk"));
        ternaryTrie.delete("mk");
        Assert.assertEquals(null, ternaryTrie.get("mk"));

    }
}
