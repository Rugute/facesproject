/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.facesreception.api.impl;


import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.facesreception.DemoPerson;
import org.openmrs.module.facesreception.api.FacesReceptionService;
import org.openmrs.module.facesreception.api.db.FacesReceptionDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * It is a default implementation of {@link FacesReceptionService}.
 */
public class FacesReceptionServiceImpl extends BaseOpenmrsService implements FacesReceptionService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private FacesReceptionDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(FacesReceptionDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public FacesReceptionDAO getDao() {
	    return dao;
    }

    public DemoPerson getPersonDetails(int personID){
        DemoPerson p = new DemoPerson();
        return p;
    }

    public List<DemoPerson> getPersonList(Date startDob, Date endDob)
    {
        List<DemoPerson> patientList = dao.getPersonList(startDob,endDob);

        return patientList;

    }

}