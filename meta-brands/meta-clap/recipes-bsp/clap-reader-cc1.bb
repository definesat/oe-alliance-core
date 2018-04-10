SUMMARY = "libreader for clap Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(cc1)$"

SRCDATE = "20180411"

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

SRC_URI[md5sum] = "61eaf52aa6d46ca6d4a4bf4981a093f8"
SRC_URI[sha256sum] = "8426097194ac33f793090f585128dc9a8d442bceac7a180b886f8d43078f6e85"
