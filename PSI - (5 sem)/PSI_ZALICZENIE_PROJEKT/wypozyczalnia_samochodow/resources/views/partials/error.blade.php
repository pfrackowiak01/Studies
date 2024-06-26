<br>
<i><p>
    @if($errors->any())
        <div class="alert alert-danger text-red-600">
            <ul>
                @foreach($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif
</p></i>