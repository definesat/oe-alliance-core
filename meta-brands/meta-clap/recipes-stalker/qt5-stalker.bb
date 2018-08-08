SUMMARY = "Qt5 OpenGL ES 2.0 Test Application"
DESCRIPTION = "This application is used to test OpenGL ES 2.0 rendering \
in a simple QWindow, plus multi-touch input, window orientation, window \
focus handling and some other game-related features."
LICENSE = "CLOSED"

PV = "${SRCPV}"

DEPENDS = "qtbase qtsensors qtwebkit boost"

# Depends on gles2 enabled and that's not default configuration
EXCLUDE_FROM_WORLD = "1"

SRC_URI = "git://git@github.com/definesat/qtstalkerv2.git;protocol=ssh"
SRCREV = "d468a7810596afc5cf61a50cf659db130c97454e"
S = "${WORKDIR}/git"

DEPENDS += "clap-libs-${MACHINE}"

inherit qmake5

do_install() {
    install -d ${D}${datadir}/stalker
    install -m 0755 ${B}/stalker ${D}${datadir}/stalker/
}

FILES_${PN} += "${datadir}"