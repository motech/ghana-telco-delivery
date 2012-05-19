package org.motechproject.telco;

import org.junit.Before;
import org.junit.Test;
import org.motechproject.telco.couchdb.CouchDbMetaData;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CouchDbMetaDataTest {

    CouchDbMetaData metaData;

    @Before
    public void setup(){
        metaData = new CouchDbMetaData("localhost", CouchDbMetaData.DEFAULT_PORT);
    }

    @Test
    public void shouldGetDesignDocs() throws Exception {

        final List<String> designDocNames = metaData.getDesignDocNames("ghana-telco");
        assertTrue(designDocNames.size() > 0);
    }

    @Test
    public void shouldGetListOfDatabases() throws Exception {
        List<String> dbList = metaData.getApplicationDatabases();
        assertTrue(dbList.size()>0);
    }
}

