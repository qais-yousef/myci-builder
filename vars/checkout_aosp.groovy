def call(branch, num_parallel_jobs, force_sync) {
	sh """
		mkdir -p aosp

		pushd aosp

		if [ "${force_sync}" == "true" ]; then
			rm -f .branch.${branch}
		fi

		if [ ! -e .branch.${branch} ]; then
			rm -f .branch.*

			repo init -u https://android.googlesource.com/platform/manifest -b ${branch}
			repo sync -cd --force-sync --fail-fast -j ${num_parallel_jobs}
			touch .branch.${branch}

		fi

		popd
	"""
}
