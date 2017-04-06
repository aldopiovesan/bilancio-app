/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Utente;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "Utente")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
    , @NamedQuery(name = "Utente.findByIdUtente", query = "SELECT u FROM Utente u WHERE u.idUtente = :idUtente")
    , @NamedQuery(name = "Utente.findByNome", query = "SELECT u FROM Utente u WHERE u.nome = :nome")
    , @NamedQuery(name = "Utente.findByMail", query = "SELECT u FROM Utente u WHERE u.mail = :mail")
    , @NamedQuery(name = "Utente.findByPwd", query = "SELECT u FROM Utente u WHERE u.pwd = :pwd")
    , @NamedQuery(name = "Utente.findBySaldo", query = "SELECT u FROM Utente u WHERE u.saldo = :saldo")
    , @NamedQuery(name = "Utente.findByMailPwd", query = "SELECT u FROM Utente u WHERE u.mail = :mail AND u.pwd = :pwd")
})
public class Utente implements Serializable
{

    public static final String FIND_ALL = "Utente.findAll";
    public static final String FIND_BY_MAIL_PWD = "Utente.findByMailPwd";
    public static final String FIND_BY_ID = "Utente.findByIdUtente";
    public static final String FIND_BY_MAIL = "Utente.findByMail";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdUtente")
    private Integer idUtente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Pwd")
    private String pwd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Saldo")
    private double saldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtente")
    private Collection<Variazione> variazioneCollection;

    public Utente()
    {
    }

    public Utente(Integer idUtente)
    {
        this.idUtente = idUtente;
    }

    public Utente(Integer idUtente, String nome, String mail, String pwd, double saldo)
    {
        this.idUtente = idUtente;
        this.nome = nome;
        this.mail = mail;
        this.pwd = pwd;
        this.saldo = saldo;
    }

    public Integer getIdUtente()
    {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente)
    {
        this.idUtente = idUtente;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    @XmlTransient
    public Collection<Variazione> getVariazioneCollection()
    {
        return variazioneCollection;
    }

    public void setVariazioneCollection(Collection<Variazione> variazioneCollection)
    {
        this.variazioneCollection = variazioneCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idUtente != null ? idUtente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente))
        {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.idUtente == null && other.idUtente != null) || (this.idUtente != null && !this.idUtente.equals(other.idUtente)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.airhacks.Utente[ idUtente=" + idUtente + " ]";
    }

}
