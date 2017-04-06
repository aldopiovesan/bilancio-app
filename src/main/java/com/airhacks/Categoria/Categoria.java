/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Categoria;

import com.airhacks.Variazione.Variazione;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "Categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "Categoria.findByDescrizione", query = "SELECT c FROM Categoria c WHERE c.descrizione = :descrizione")
//    @NamedQuery(name = "Categoria.findByUser", query = "SELECT DISTINCT e.idCategoria FROM CategoriaPointer e WHERE e.idVariazione.idUtente = :usr")
    , @NamedQuery(name = "Categoria.findByIdUtente", query = "SELECT DISTINCT c FROM Categoria c INNER JOIN c.VariazioneCollection v WHERE v.idUtente = :idUtente")
})
public class Categoria implements Serializable {

    public static final String FIND_BY_IDUTENTE = "Categoria.findByIdUtente";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCategoria")
    private Integer idCategoria;
    @Size(max = 500)
    @Column(name = "Descrizione")
    private String descrizione;

    @ManyToMany(mappedBy="categoriaCollection", cascade = CascadeType.ALL)
    private Collection<Variazione> VariazioneCollection;
    @XmlTransient
    public Collection<Variazione> getVariazioneCollection() {
        return VariazioneCollection;
    }
    public void setVariazioneCollection(Collection<Variazione> variazioneCollection) {
        this.VariazioneCollection = variazioneCollection;
    }
    
    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airhacks.Categoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
