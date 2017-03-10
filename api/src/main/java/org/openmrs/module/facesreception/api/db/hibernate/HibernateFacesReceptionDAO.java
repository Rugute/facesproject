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
package org.openmrs.module.facesreception.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.openmrs.module.facesreception.DemoPerson;
import org.openmrs.module.facesreception.api.db.FacesReceptionDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * It is a default implementation of  {@link FacesReceptionDAO}.
 */
public class HibernateFacesReceptionDAO implements FacesReceptionDAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }


    public DemoPerson getPersonDetails(int personID)
	{
		DemoPerson p = new DemoPerson();
	return p;
	}
	//public List<DemoPerson> getPersonList(Date startDob, Date endDob);

	public List<DemoPerson> getPersonList(Date startDob, Date endDob)
	{
		List<DemoPerson> listofPateints = new ArrayList<DemoPerson>();
        StringBuilder strSQL = new StringBuilder();
        strSQL.append("select p.person_id,p.birthdate,p.gender,concat_ws(' ',pn.given_name,pn.family_name) as name ");
		strSQL.append("from person p ");
		strSQL.append("join person_name pn on pn.person_id=p.person_id");
		strSQL.append("where p.voided=0 and birthdate between :startDate and :endDate");

		Query queryResults= sessionFactory.getCurrentSession().createSQLQuery(strSQL.toString());

		//Passing Paramenters
		if(startDob!=null)
		{
			queryResults.setDate("birthdate",startDob);
		}
		if(endDob!=null)
		{
			queryResults.setDate("birthdate",endDob);
		}

		List list = queryResults.list();
		Iterator it = list.iterator();
		while (it.hasNext()){
			Object[] row = (Object[]) it.next();
			DemoPerson p = new DemoPerson();
			p.setPersonID((Integer) row[0]);
			p.setDOB((Date) row[1]);
			p.setGender((String) row[2]);
			p.setPersonName((String) row[3]);
			listofPateints.add(p);
		}
		return  listofPateints;

	}
}
