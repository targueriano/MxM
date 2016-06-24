from distutils.core import setup
from Cython.Build import cythonize
from distutils.extension import Extension
from Cython.Distutils import build_ext

ext_modules=[
    Extension("pymxm_p",
              ["pymxm_p.pyx"],
              extra_compile_args = ["-fopenmp" ],
              extra_link_args=['-fopenmp']
              ) 
]

setup( 
  name = "pymxm_p",
  cmdclass = {"build_ext": build_ext},
  ext_modules = ext_modules
)