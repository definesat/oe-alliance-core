SUMMARY = "libreader for clap Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(cc1)$"

SRCDATE = "20180728"

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

SRC_URI[md5sum] = "aa16abe94d3266e2b81f5f3a21a82c07"
SRC_URI[sha256sum] = "48afdc4a2776d37d66f6d8264ee8adf2f997826f2370cf4c7e64a10584dabdfb"