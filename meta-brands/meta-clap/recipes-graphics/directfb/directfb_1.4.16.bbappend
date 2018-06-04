FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

EXTRA_OECONF += "\
    --with-inputdrivers=linuxinput \
"
