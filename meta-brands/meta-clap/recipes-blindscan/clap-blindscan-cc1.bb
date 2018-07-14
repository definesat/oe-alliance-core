SUMMARY = "blindscan for clap Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCDATE = "20180714"

PV = "${SRCDATE}"
PR = "r0"

SRC_URI  = "http://define-sw.dyndns.tv:8082/clap/cc1-blindscan-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/clap-blindscan ${D}/${bindir}
}

do_package_qa() {
}

FILES_${PN}  = "${bindir}/clap-blindscan"

SRC_URI[md5sum] = "ecc44a61839bce0954fdbb7ec11fbfc8"
SRC_URI[sha256sum] = "4a6040bddf973dc83737577da5322ff2b69cbf1725beef10ebfa427d8b1f8294"


