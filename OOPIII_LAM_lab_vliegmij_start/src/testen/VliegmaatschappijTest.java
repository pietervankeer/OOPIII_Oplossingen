package testen;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Vliegmaatschappij;


public class VliegmaatschappijTest
{
    private Vliegmaatschappij v1;
    private String[] data1, data2;

    @BeforeEach
    public void before()
    {
        data1 = new String[] {"Brussels Airlines", "Canada Air", "Lufthansa", "Swiss Air"};
        data2 = new String[] {};
        v1 = new Vliegmaatschappij(data1);
    }

    @Test
    public void maakVliegmaatschappij_zonderData_werptException()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Vliegmaatschappij(data2));
    }

    @Test
    public void getNaam_v1_geeftBrusselsAirlines()
    {
        Assertions.assertEquals("Brussels Airlines", v1.getNaam());
    }

    @Test
    public void getPartners_v1_geeftAllePartners()
    {
        String[] gegevens = new String[] {"Canada Air", "Lufthansa", "Swiss Air"};
        List<String> partners = Arrays.asList(gegevens);
        Assertions.assertEquals(partners, v1.getPartners());
    }

    @Test
    public void isPartner_bestaandePartner_controleTrue()
    {
    	Assertions.assertTrue(v1.isPartner("Lufthansa"));
    }

    @Test
    public void isPartner_onbestaandePartner_controleFalse()
    {
    	Assertions.assertFalse(v1.isPartner("KLM"));
    }


}