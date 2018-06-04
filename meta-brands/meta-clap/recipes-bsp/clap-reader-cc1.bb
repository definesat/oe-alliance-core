SUMMARY = "libreader for clap Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(cc1)$"

SRCDATE = "20180605"

PV = "${SRCDATE}"
PR = "r0"

RPROVIDES_${PN}  = "libreader"
RREPLACES_${PN}  = "libreader"
RCONFLICTS_${PN} = "libreader"

SRC_URI = "http://define-sw.dyndns.tv:8082/clap/${MACHINE}-libreader-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/libreader ${D}/${bindir}
}

do_package_qa() {
}

FILES_${PN}  = "${bindir}/libreader"

SRC_URI[md5sum] = "6c6efa90fc5d8db5ca7d666b9a2798d7"
SRC_URI[sha256sum] = "49ca192e477545430c8fed1009c8b8cbddb8bfa1857f909c817d2e95f861e8e6"
