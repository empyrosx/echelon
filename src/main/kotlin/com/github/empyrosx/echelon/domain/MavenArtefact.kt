package com.github.empyrosx.echelon.domain

class MavenArtefact private constructor(
        private val artefactPath: String,
        private val artefactName: String
) : Artefact {

    private val artefactDepth = if (artefactPath == ROOT) 0 else artefactPath.count { it == '/' } + 1

    override val path: String
        get() = artefactPath
    override val name: String
        get() = artefactName
    override val depth: Int
        get() = artefactDepth
    companion object {

        private const val ROOT = "/"

        fun parse(fullPath: String): MavenArtefact {
            val pathSeparator = fullPath.lastIndexOf('/')
            val name = fullPath.substring(pathSeparator + 1)
            val path = if (pathSeparator > -1) fullPath.substring(0, pathSeparator) else "/"
            return MavenArtefact(path, name)
        }
    }
}