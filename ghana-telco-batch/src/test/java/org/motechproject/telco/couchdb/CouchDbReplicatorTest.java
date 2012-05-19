package org.motechproject.telco.couchdb;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CouchDbReplicatorTest {
    
    @Test
    public void testJSONRequestAsString() throws JSONException {
        CouchDbMetaData couchDbMetaData = new CouchDbMetaData("localhost", CouchDbMetaData.DEFAULT_PORT);
        JSONObject jsonObject = new CouchDbReplicator().constructJSONRequest(couchDbMetaData, "telco");
        String expected = "{\"continuous\":true,\"create_target\":true,\"source\":\"http://localhost:5984/telco\",\"target\":\"telco\"}";
        assertEquals(expected, jsonObject.toString());
    }
    
}
