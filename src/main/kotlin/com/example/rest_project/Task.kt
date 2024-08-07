package com.example.rest_project

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "TASKS")
open class Task {
    @Id
    @Column(name = "taskid", nullable = false)
    open var id: Int? = null

    @Column(name = "name", length = Integer.MAX_VALUE)
    open var name: String? = null

    @Column(name = "complete")
    open var complete: Boolean? = null
}