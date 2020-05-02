package models;

/**
 * Model class for the events
 * 
 * @author Kahlie
 * @date 4/28/20
 */

import api.adapters.EventsAPIAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;

public class EventsModel {

    protected int zipcode;
    protected Map categoriesMap;  
    protected Map eventTitleMap;
    protected Map eventDescriptionMap;
    protected Map eventVenueNameMap;
    protected Map eventImageMap;
    protected Map eventUrlMap;
    protected Map eventVenueAddressMap;

    private static final int eventTitleMapINDEX = 0;    
    private static final int eventVenueNameMapINDEX = 1;
    private static final int eventImageMapINDEX = 2;
    private static final int eventDescriptionMapINDEX = 3;
    private static final int eventUrlMapINDEX = 4;
    private static final int eventVenueAddressMapINDEX = 5;
    private static final int categoriesMapINDEX = 0;
    
    protected final static EventsAPIAdapter adapter = new EventsAPIAdapter();
    
    /**
     * Returns the model that has event information
     * @param _category
     * @param _zipcode
     * @return
     * @throws IOException
     * @throws JSONException 
     */
    public static EventsModel loadEventsByZipcode(String _category, int _zipcode) throws IOException, JSONException{
        EventsModel useModel = new EventsModel();
        ArrayList<Map> tempStorageForMaps = adapter.loadEventsByZipcode(_category, _zipcode);
        
        useModel.setZipcode(_zipcode);
        
        Map comedyEventTitleMap = tempStorageForMaps.get(eventTitleMapINDEX);
        useModel.setEventTitleMap(comedyEventTitleMap);
        
        Map comedyEventDescriptionMap = tempStorageForMaps.get(eventDescriptionMapINDEX);
        useModel.setEventDescriptionMap(comedyEventDescriptionMap);
        
        Map comedyEventVenueNameMap = tempStorageForMaps.get(eventVenueNameMapINDEX);
        useModel.setEventVenueNameMap(comedyEventVenueNameMap);
        
        Map comedyEventImageMap = tempStorageForMaps.get(eventImageMapINDEX);
        useModel.setEventImageMap(comedyEventImageMap);
        
        Map comedyEventUrlMap = tempStorageForMaps.get(eventUrlMapINDEX);
        useModel.setEventUrlMap(comedyEventUrlMap);
        
        Map comedyEventVenueAddressMap = tempStorageForMaps.get(eventVenueAddressMapINDEX);
        useModel.setEventVenueAddressMap(comedyEventVenueAddressMap);

        return useModel;      
    }
    
    /**
     * Returns the model that has the categories map
     * @return
     * @throws IOException
     * @throws JSONException 
     */
    public static EventsModel loadCategories() throws IOException, JSONException{
        EventsModel useModel = new EventsModel();
        ArrayList<Map> tempStorageForMaps = adapter.loadCategories();
        
        Map categoriesMap = tempStorageForMaps.get(categoriesMapINDEX);
        useModel.setCategoriesMap(categoriesMap);

        return useModel;         
    }

    //================= GETTERS ===============
    public int getZipcode() {
        return zipcode;
    }

    public Map getEventTitleMap() {
        return eventTitleMap;
    }

    public Map getCategoriesMap() {
        return categoriesMap;
    }
    
    public Map getEventDescriptionMap() {
        return eventDescriptionMap;
    }

    public Map getEventVenueNameMap() {
        return eventVenueNameMap;
    }

    public Map getEventImageMap() {
        return eventImageMap;
    }
    
    public Map getEventVenueAddressMap() {
        return eventVenueAddressMap;
    }

    public Map getEventUrlMap() {
        return eventUrlMap;
    }

   //================= SETTERS ===============
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
    
    public void setEventUrlMap(Map comedyEventUrlMap) {
        this.eventUrlMap = comedyEventUrlMap;
    }
    
    public void setEventVenueAddressMap(Map comedyEventVenueAddressMap) {
        this.eventVenueAddressMap = comedyEventVenueAddressMap;
    }
    
    public void setEventTitleMap(Map comedyEventTitleMap) {
        this.eventTitleMap = comedyEventTitleMap;
    }
    
    public void setCategoriesMap(Map categoriesMap) {
        this.categoriesMap = categoriesMap;
    }
    
    public void setEventImageMap(Map comedyEventImageMap) {
        this.eventImageMap = comedyEventImageMap;
    }
    
    public void setEventDescriptionMap(Map comedyEventDescriptionMap) {
        this.eventDescriptionMap = comedyEventDescriptionMap;
    }
    
    public void setEventVenueNameMap(Map comedyEventVenueNameMap) {
        this.eventVenueNameMap = comedyEventVenueNameMap;
    }
}