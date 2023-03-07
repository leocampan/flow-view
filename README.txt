project management

questa versione implementa solo le entità
1) Employee
2) Project

con i corrispondenti repository, service e controller.

Tra Employee e Project è definità una relazione molti a uno bidirezionale.

lato Employee
    @OneToMany(mappedBy = "leader", cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JsonIgnore
    Set<Project> projects;

lato Project
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @MapsId("employee_id")
    @JoinColumn(
            name = "leader_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_projects_leader_id"
                    )
            ) 
    @JsonIdentityReference
    private Employee leader;

La FK constraint prevede con  CascadeType.ALL
1) update e delete a cascata nel caso che un Employee sia eliminato o cha la sua chiave primaria cambi
2) @MapsId https://jakarta.ee/specifications/platform/9/apidocs/jakarta/persistence/mapsid
   Determina un attributo di relazione ManyToOne o OneToOne che fornisce il mapping per una chiave primaria
   verso l'entità padre
3) con   @JoinColumn(
            name = "leader_id", 
    si stabilisce in nome del campo chiave esterna nella parte molti della relazione
4) il campo leader_id non può essere null
5) la constraint relativa alla foreign key è identificata con
    foreignKey = @ForeignKey(
                    name = "fk_projects_leader_id"
                    )

6) Ricordarsi che le fk constaint anche se impostate su cascade.ALL, nel db saranno restricted sia in update che in delete.
   Si occuperà l'ORM della cancellazione/aggiornamneto a cascata

7) https://www.npmjs.com/package/swagger-ui-express 

8) https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

9) orphanRemoval = onDeleteCascade su SQL