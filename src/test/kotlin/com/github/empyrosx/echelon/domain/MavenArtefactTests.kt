package com.github.empyrosx.echelon.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MavenArtefactTests {

    @Test
    fun `Artefact can be initialized by full path`() {
        val artefact = MavenArtefact.parse("commons-lang/commons-lang/2.6/commons-lang-2.6.pom")
        assertEquals("commons-lang/commons-lang/2.6", artefact.path)
        assertEquals("commons-lang-2.6.pom", artefact.name)
    }

    @Test
    fun `Artefact can be folder`() {
        val artefact = MavenArtefact.parse("commons-lang/commons-lang/2.6")
        assertEquals("commons-lang/commons-lang", artefact.path)
        assertEquals("2.6", artefact.name)
    }

    @Test
    fun `Artefacts should form a hierarchy`() {
        assertEquals(0, MavenArtefact.parse("commons-lang").depth)
        assertEquals(1, MavenArtefact.parse("commons-lang/commons-lang").depth)
        assertEquals(2, MavenArtefact.parse("commons-lang/commons-lang/2.6").depth)
        assertEquals(3, MavenArtefact.parse("commons-lang/commons-lang/2.6/commons-lang-2.6.pom").depth)
    }
}