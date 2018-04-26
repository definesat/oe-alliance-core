SUMMARY = "libreader for clap Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(cc1)$"

SRCDATE = "20180426"

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

SRC_URI[md5sum] = "d61a9702eae0e2801101a6c7ff9903d9"
SRC_URI[sha256sum] = "35668cf38a8cc5133caa8db0c911c4585ebaa8d6d8cff2f87e0467c4a9d3acc2"
