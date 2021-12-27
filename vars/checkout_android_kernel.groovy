def call(branch, num_parallel_jobs, force_sync) {
	sh """
		mkdir -p android-kernel

		pushd android-kernel

		if [ "${force_sync}" == "true" ]; then
			rm -f .${branch}
		fi

		if [ ! -e .${branch} ]; then

			repo init -u https://android.googlesource.com/kernel/manifest -b ${branch}
			repo sync -cd --force-sync --fail-fast -j ${num_parallel_jobs}
			touch .${branch}

		fi


		popd
	"""
}
