SUMMARY = "halt for clap Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCDATE = "20180606"

PV = "${SRCDATE}"
PR = "r0"

SRC_URI  = "http://define-sw.dyndns.tv:8082/clap/cc1-hihalt-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/hihalt ${D}/${bindir}
}

do_package_qa() {
}

FILES_${PN}  = "${bindir}/hihalt"

SRC_URI[md5sum] = "7d5dae625f9c5ad7c13e8099f10455bf"
SRC_URI[sha256sum] = "249559623db2eb77f347f14d9a9b0be44b40c5ee797d4a304c930dd2419f84fe"


