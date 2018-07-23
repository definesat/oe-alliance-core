SUMMARY = "libreader for clap Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(cc1)$"

SRCDATE = "20180723"

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

SRC_URI[md5sum] = "fe4069b5d7eb8c2ddcc59e9935f180dd"
SRC_URI[sha256sum] = "f626a9c4f7abdb12c6e9f686bd576933111fcff729a5411233f367e3ac00b269"
