def call() {
	sh """
		out=\$(ls aosp/out/target/product/)
		rm -rf \$out
		mkdir -p \$out
		files=\$(find aosp/out/target/product/\$out -maxdepth 1 -type f -name '*.img' )
		cp \$files \$out/
		# fastboot flashall requires android-info.txt too
		cp aosp/out/target/product/\$out/android-info.txt \$out/
		tar cJf \$out.tar.xz \$out
		rm -rf \$out
	"""
}
