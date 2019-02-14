package es.indra.academia.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String etapa;

	private String nivel;

	//bi-directional one-to-one association to Asignatura
	@OneToOne(mappedBy="curso1")
	private Asignatura asignatura;

	//bi-directional many-to-one association to Asignatura
	@OneToMany(mappedBy="curso", fetch=FetchType.EAGER)
	private List<Asignatura> asignaturas;

	public Curso() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtapa() {
		return this.etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public List<Asignatura> getAsignaturas() {
		return this.asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Asignatura addAsignatura(Asignatura asignatura) {
		getAsignaturas().add(asignatura);
		asignatura.setCurso(this);

		return asignatura;
	}

	public Asignatura removeAsignatura(Asignatura asignatura) {
		getAsignaturas().remove(asignatura);
		asignatura.setCurso(null);

		return asignatura;
	}

}