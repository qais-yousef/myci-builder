def call() {
	sh """
		pushd android-kernel

		build_script=`ls build*.sh`

		if [ "x\$build_script" == "x" ]; then
			./build/build.sh
		else
			./\$build_script
		fi

		popd
	"""
}
