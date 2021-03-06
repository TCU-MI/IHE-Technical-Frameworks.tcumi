package edu.tcu.mi.ihe.iti.model;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import edu.tcu.mi.ihe.constants.RegistryStoredQueryUUIDs;
import edu.tcu.mi.ihe.constants.StoredQueryConstants;

/**
 * Retrieve Association objects whose sourceObject or targetObject attribute match $uuid. 
 * @author TCUMI
 *
 */
public class GetAssociations extends QueryModel {
	
	public GetAssociations(){
		super(RegistryStoredQueryUUIDs.GET_ASSOCIATIONS_UUID);
	}
	
	/**
	 * Retrieve Association objects whose sourceObject or targetObject attribute match $uuid.
	 * @param val
	 * @return
	 */
	public GetAssociations andUuid(String ... val){
		this.parameters.put(StoredQueryConstants.UUID, Lists.newArrayList(val));
		return this;
	}
	
	public GetAssociations andHomeCommunityId(String val){
		this.parameter.put(StoredQueryConstants.HOME_COMMUNITY_ID, val);
		return this;
	}

	@Override
	public boolean validate() {
		return this.parameters.containsKey(StoredQueryConstants.UUID);
	}
	
	@Override
	public String toString(){
		return new Gson().toJson(this);
	}
	
}
