package pwa.dataaccess;

/**
 * Created by Peder on 06.09.2017.
 */

import com.sun.org.apache.xpath.internal.operations.Bool;
import pwa.model.Bruker;
import pwa.model.Vare;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HandlelisteEAO {
    @PersistenceContext(name = "studentPersistenceUnit")
    private EntityManager em;

    public List<Vare> visAlleVarer(){
        List<Vare> varer = em.createNamedQuery("Vare.visAlle").getResultList();
        return varer;
    }

    public Boolean leggTilBruker(String brukernavn, String passord) {
        Bruker funnet = finnBrukerPaaNavn(brukernavn);
        if(funnet == null){
            Bruker ny = new Bruker();
            ny.setBrukernavn(brukernavn);
            ny.setPassord(passord);
            em.persist(ny);
        }
        return funnet == null;
    }

    public Bruker finnBrukerPaaNavn(String navn) {
        List<Bruker> bruker = em.createNamedQuery("Bruker.finnPaaNavn").setParameter("brukernavn",navn).getResultList();
        if(bruker.isEmpty()){
            return null;
        }
        return bruker.get(0);
    }
    /*public void leggTil(Klasse b) {
        em.persist(b);
    }

    public void oppdaterKlasse(Klasse b){
        em.merge(b);
    }
    public void slettKlasse(Klasse id) {
        em.remove(em.find(Bruker.class, id));
    }*/
}
