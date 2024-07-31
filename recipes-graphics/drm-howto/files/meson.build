project('drm-howto', ['c'],
        version : '0.1.0',
        meson_version : '>= 0.55.0',
        license : 'MIT',
        default_options : [
            'b_pie=true',
            'b_staticpic=true',
            'b_asneeded=true',
            'b_lto_mode=default',
            'b_lto=true',
        ],
)

drm_dep = dependency('libdrm', include_type : 'system', required : true)


executable('modeset', ['drm-howto/modeset.c'],
           dependencies : [
               drm_dep,
           ],
           install : true,
)

executable('modeset-atomic', ['drm-howto/modeset-atomic.c'],
           dependencies : [
               drm_dep,
           ],
           install : true,
)

executable('modeset-double-buffered', ['drm-howto/modeset-double-buffered.c'],
           dependencies : [
               drm_dep,
           ],
           install : true,
)

executable('modeset-vsync', ['drm-howto/modeset-vsync.c'],
           dependencies : [
               drm_dep,
           ],
           install : true,
)

devenv = environment()
if meson.version().version_compare('>=0.58.0')
    meson.add_devenv(devenv)
endif
