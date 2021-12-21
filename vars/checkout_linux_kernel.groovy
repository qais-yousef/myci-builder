def call(gitremote, version) {
	sh """
		if [ ! -d linux ]; then
			git clone https://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git
		fi

		remote=\$(echo ${gitremote} | awk '{print \$1}')
		link=\$(echo ${gitremote} | awk '{print \$2}')

		pushd linux

		remote_exists=\$(git remote -v | grep \$link || true)

		if [ "x\$remote_exists" == "x" ]; then
			git remote add \$remote \$link
		fi

		git fetch \$remote
		git checkout ${version}

		popd
	"""
}
