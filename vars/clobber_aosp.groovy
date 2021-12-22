def call() {
	sh """
		if [ -d aosp ]; then
			pushd aosp
			make clobber
			popd
		fi
	"""
}
