require recipes-mediacenter/kodi/stb-kodi_${PV}.bb

SRCDATE = "20181026"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_remove = "file://e2player.patch \
           file://add-gstplayer-support.patch \
"

SRC_URI_append = "http://define-sw.dyndns.tv:8082/clap/hiplayer_gcc8_${SRCDATE}.tar.gz \
                  file://hiplayer.patch \
"

SRC_URI[md5sum] = "364e89ecc7f74149e4d8164227c67663"
SRC_URI[sha256sum] = "80edf52ea00de02686077f8cbbe60a9a63d1eaac4852316bf47074c1ddeb64bc"

DEPENDS += "clap-libs-${MACHINE}"
PROVIDES += "virtual/kodi"
RPROVIDES_${PN} += "virtual/kodi"
PROVIDES += "kodi"
RPROVIDES_${PN} += "kodi"

RDEPENDS_${PN} += "clap-libs-${MACHINE}"
RDEPENDS_${PN} += "clap-opengl-${MACHINE}"

do_configure_append() {
        install -d ${D}${libdir}
        install -m 0755 ${WORKDIR}/hiadp.a      ${WORKDIR}/git/xbmc/linux/hisi/
        install -m 0755 ${WORKDIR}/hiplayer.a   ${WORKDIR}/git/xbmc/cores/hiplayer/
}

EXTRA_OECONF += " \
    --with-platform=clap-cortexa15 \
    --with-ffmpeg=stb \
"
