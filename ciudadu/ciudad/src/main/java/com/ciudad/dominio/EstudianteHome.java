package com.ciudad.dominio;

// Generated 08-sep-2014 21:11:24 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Estudiante.
 * @see com.ciudad.dominio.Estudiante
 * @author Hibernate Tools
 */
@Stateless
public class EstudianteHome {

	private static final Log log = LogFactory.getLog(EstudianteHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Estudiante transientInstance) {
		log.debug("persisting Estudiante instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Estudiante persistentInstance) {
		log.debug("removing Estudiante instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Estudiante merge(Estudiante detachedInstance) {
		log.debug("merging Estudiante instance");
		try {
			Estudiante result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Estudiante findById(EstudianteId id) {
		log.debug("getting Estudiante instance with id: " + id);
		try {
			Estudiante instance = entityManager.find(Estudiante.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
