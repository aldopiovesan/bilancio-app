/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Variazione;

import com.airhacks.Utente.Utente;
import com.airhacks.Categoria.Categoria;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "Variazione")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variazione.findAll", query = "SELECT v FROM Variazione v")
    , @NamedQuery(name = "Variazione.findByIdVariazione", query = "SELECT v FROM Variazione v WHERE v.idVariazione = :idVariazione")
    , @NamedQuery(name = "Variazione.findByAmmontare", query = "SELECT v FROM Variazione v WHERE v.ammontare = :ammontare")
    , @NamedQuery(name = "Variazione.findByData", query = "SELECT v FROM Variazione v WHERE v.data = :data")
    , @NamedQuery(name = "Variazione.findByDescrizione", query = "SELECT v FROM Variazione v WHERE v.descrizione = :descrizione")
    , @NamedQuery(name = "Variazione.findByIdUtente", query = "SELECT v FROM Variazione v WHERE v.idUtente = :idUtente")})
public class Variazione implements Serializable {

    public static final String FIND_BY_IDUTENTE = "Variazione.findByIdUtente";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdVariazione")
    private Integer idVariazione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ammontare")
    private double ammontare;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new Date();
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Descrizione")
    private String descrizione;
    @JoinColumn(name = "IdUtente", referencedColumnName = "IdUtente")
    @ManyToOne(optional = false)
    private Utente idUtente;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CategoriaPointer",
            joinColumns
            = @JoinColumn(name = "idVariazione", referencedColumnName = "idVariazione"),
            inverseJoinColumns
            = @JoinColumn(name = "IdCategoria", referencedColumnName = "IdCategoria")
    )
    
    private Collection<Categoria> categoriaCollection;

    public Variazione() {
    }

    public Variazione(Integer idVariazione) {
        this.idVariazione = idVariazione;
    }

    public Variazione(Integer idVariazione, double ammontare, Date data, String descrizione) {
        this.idVariazione = idVariazione;
        this.ammontare = ammontare;
        this.data = data;
        this.descrizione = descrizione;
    }

    public Integer getIdVariazione() {
        return idVariazione;
    }

    public void setIdVariazione(Integer idVariazione) {
        this.idVariazione = idVariazione;
    }

    public double getAmmontare() {
        return ammontare;
    }

    public void setAmmontare(double ammontare) {
        this.ammontare = ammontare;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Utente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utente idUtente) {
        this.idUtente = idUtente;
    }

    @XmlTransient
    public Collection<Categoria> getCategoriaCollection() {
        return categoriaCollection;
    }

    public void setCategoriaCollection(Collection<Categoria> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVariazione != null ? idVariazione.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variazione)) {
            return false;
        }
        Variazione other = (Variazione) object;
        if ((this.idVariazione == null && other.idVariazione != null) || (this.idVariazione != null && !this.idVariazione.equals(other.idVariazione))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airhacks.Variazione[ idVariazione=" + idVariazione + " ]";
    }

}
