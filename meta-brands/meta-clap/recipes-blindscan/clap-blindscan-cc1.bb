SUMMARY = "blindscan for clap Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCDATE = "20180629"

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

SRC_URI[md5sum] = "6690b29d7d0a43e8ef98b85b2ecb5b58"
SRC_URI[sha256sum] = "f6d28315f926fecaf813b0de7850b6c0bfe9e16c99cecd6056657d9556edffd0"


