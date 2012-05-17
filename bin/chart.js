(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  if (this.LSC == null) this.LSC = {};

  this.LSC.Chart = (function() {

    function Chart(paper, x, y) {
      this.paper = paper;
      this.x = x != null ? x : 0;
      this.y = y != null ? y : cfg.toolbar.height;
      this.deserialize = __bind(this.deserialize, this);
      this.serialize = __bind(this.serialize, this);
      this.fromJSON = __bind(this.fromJSON, this);
      this.toJSON = __bind(this.toJSON, this);
      this.getInstanceByName = __bind(this.getInstanceByName, this);
      this.deleteSelection = __bind(this.deleteSelection, this);
      this.deleteInstance = __bind(this.deleteInstance, this);
      this.deleteMessage = __bind(this.deleteMessage, this);
      this.clearSelection = __bind(this.clearSelection, this);
      this.moveMessage = __bind(this.moveMessage, this);
      this.GetLocation = __bind(this.GetLocation, this);
      this.locationY = __bind(this.locationY, this);
      this.xNumber = __bind(this.xNumber, this);
      this.numberX = __bind(this.numberX, this);
      this.createInstance = __bind(this.createInstance, this);
      this.createMessage = __bind(this.createMessage, this);
      this.mouseUp = __bind(this.mouseUp, this);
      this.mouseMove = __bind(this.mouseMove, this);
      this.mouseDown = __bind(this.mouseDown, this);
      this.addMessage = __bind(this.addMessage, this);
      this.moveInstance = __bind(this.moveInstance, this);
      this.updateSize = __bind(this.updateSize, this);
      this.update = __bind(this.update, this);
      this.unedit = __bind(this.unedit, this);
      this.edit = __bind(this.edit, this);
      this.name = "Untitled Chart";
      this.messages = [];
      this.instances = [];
      this.lineloc = 1;
      this.locations = 3;
      this.resloc = 2;
      this.prechart = this.paper.path("");
      this.prechart.attr({
        "stroke-dasharray": "--"
      });
      this.postchart = this.paper.path("");
      this.restrictchart = this.paper.path("");
      this.isAddingMessage = false;
      this.addingM = null;
      $("#workspace").css("cursor", "default");
      this.title = this.paper.text(10, 20, this.name);
      this.title.attr({
        "font-size": 24,
        "text-anchor": 'start'
      });
      this.title.dblclick(this.edit);
    }

    Chart.prototype.change = function(callback) {
      if (callback != null) {
        return this.changeCallback = callback;
      } else {
        return typeof this.changeCallback === "function" ? this.changeCallback(this) : void 0;
      }
    };

    Chart.prototype.edit = function() {
      var _this = this;
      if (this.editor == null) {
        this.editor = $("<input type='text' id='input'/>");
        this.editor.addClass("editor");
        this.editor.css({
          left: '10px',
          top: '2px',
          width: "95%",
          "font-size": 24
        });
        this.editor.appendTo("#workspace");
        this.title.attr({
          text: "",
          opacity: 0
        });
        return this.editor.val(this.name).focus().select().blur(this.unedit).keypress(function(event) {
          if (event.keyCode === 13) return _this.unedit();
        });
      }
    };

    Chart.prototype.unedit = function(event) {
      if (this.editor != null) {
        if (this.editor.val() === "") {
          event.stopPropagation();
          event.preventDefault();
          return;
        }
        this.name = this.editor.val();
        this.title.attr({
          text: this.name,
          opacity: 1
        });
        this.editor.remove();
        this.editor = null;
        return this.change();
      }
    };

    Chart.prototype.update = function(instant) {
      var height, hi, instance, message, postheight, preheight, restrictheight, width, yi, _i, _j, _len, _len2, _ref, _ref2;
      if (instant == null) instant = false;
      if (instant) LSC.instant();
      width = Math.max(cfg.instance.width * this.instances.length, cfg.chart.minwidth);
      preheight = cfg.instance.head.height + cfg.margin + cfg.location.height * this.lineloc;
      this.prechart.update({
        path: "M " + (this.x + cfg.margin + cfg.prechart.padding) + " " + (this.y + cfg.margin) + "\nh " + width + "\nl " + cfg.prechart.padding + " " + (preheight / 2) + "\nl -" + cfg.prechart.padding + " " + (preheight / 2) + "\nh -" + width + "\nl -" + cfg.prechart.padding + " -" + (preheight / 2) + " z"
      });
      postheight = 2 * cfg.margin + cfg.location.height * (this.resloc - this.lineloc);
      this.postchart.update({
        path: "M " + (this.x + cfg.margin + cfg.prechart.padding) + "," + (this.y + cfg.margin + preheight) + "\nh " + width + " v " + postheight + " h -" + width + " z"
      });
      restrictheight = cfg.location.height * (this.locations - this.resloc) - cfg.location.height;
      this.restrictchart.update({
        path: "M " + (this.x + cfg.margin + cfg.prechart.padding) + "," + (this.y + cfg.margin + preheight + postheight) + "\nh " + width + " v " + restrictheight + " h -" + width + " z"
      });
      _ref = this.instances;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        instance = _ref[_i];
        yi = this.y + 2 * cfg.margin;
        hi = preheight + postheight - cfg.margin * 2;
        instance.update(yi, hi);
      }
      _ref2 = this.messages;
      for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
        message = _ref2[_j];
        message.update();
      }
      height = this.y + cfg.margin + preheight + postheight + cfg.margin + restrictheight;
      this.title.attr({
        text: this.name
      });
      this.updateSize(this.x + 2 * (cfg.margin + cfg.prechart.padding) + width, height);
      if (instant) return LSC.animate();
    };

    Chart.prototype.updateSize = function(width, height) {
      width = Math.max($(window).width() - cfg.sidebar.width - cfg.margin, width);
      if (width !== this.width || height !== this.height) {
        this.width = width;
        this.height = height;
        return this.paper.setSize(width, height);
      }
    };

    Chart.prototype.moveInstance = function(instance, number) {
      var i, prev, _i, _j, _len, _len2, _ref, _ref2;
      prev = instance.number;
      if (prev < number) {
        _ref = this.instances;
        for (_i = 0, _len = _ref.length; _i < _len; _i++) {
          i = _ref[_i];
          if (prev <= i.number && i.number <= number) i.number -= 1;
        }
      }
      if (prev > number) {
        _ref2 = this.instances;
        for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
          i = _ref2[_j];
          if (number <= i.number && i.number <= prev) i.number += 1;
        }
      }
      instance.number = number;
      return this.update();
    };

    Chart.prototype.addMessage = function() {
      if (this.instances.length > 1) {
        this.isAddingMessage = true;
        $("#workspace").css("cursor", "crosshair");
        return this.addingM = null;
      }
    };

    Chart.prototype.mouseDown = function(event) {
      var loc, s_num, t_num, x;
      if (this.isAddingMessage) {
        event.stopPropagation();
        x = LSC.pageX2RaphaelX(event.pageX);
        s_num = this.xNumber(x);
        if (this.numberX(s_num) > x) {
          t_num = s_num - 1;
          if (t_num < 0) t_num = 1;
        } else {
          t_num = s_num + 1;
          if (t_num >= this.instances.length) t_num = s_num - 1;
        }
        loc = this.GetLocation(LSC.pageY2RaphaelY(event.pageY));
        return this.addingM = this.createMessage(s_num, t_num, loc, "msg()", false);
      }
    };

    Chart.prototype.mouseMove = function(event) {
      var i, loc, s_num, t_num, target, x, _i, _len, _ref;
      if (isNaN(event.pageY)) log("pis");
      if (isNaN(event.pageX)) log("pis!");
      if (this.isAddingMessage && (this.addingM != null)) {
        event.stopPropagation();
        x = LSC.pageX2RaphaelX(event.pageX);
        t_num = this.xNumber(x);
        loc = this.GetLocation(LSC.pageY2RaphaelY(event.pageY));
        if (t_num === this.addingM.source.number) {
          s_num = this.addingM.source.number;
          if (this.numberX(s_num) > x) {
            t_num = s_num;
            if (t_num < 0) t_num = 1;
          } else {
            t_num = s_num;
            if (t_num >= this.instances.length) t_num = s_num - 1;
          }
        }
        _ref = this.instances;
        for (_i = 0, _len = _ref.length; _i < _len; _i++) {
          i = _ref[_i];
          if (i.number === t_num) target = i;
        }
        if (this.addingM.target !== target || loc !== this.addingM.location) {
          this.addingM.target = target;
          if (loc !== this.addingM.location) {
            return this.moveMessage(this.addingM, loc);
          } else {
            return this.addingM.update();
          }
        }
      }
    };

    Chart.prototype.mouseUp = function(event) {
      if (this.isAddingMessage) {
        this.mouseMove(event);
        this.isAddingMessage = false;
        $("#workspace").css("cursor", "default");
        this.addingM.edit();
        return this.addingM = null;
      }
    };

    Chart.prototype.createMessage = function(sourceNumber, targetNumber, location, name, edit) {
      var i, m, msg, source, target, _i, _j, _k, _len, _len2, _len3, _ref, _ref2, _ref3;
      if (edit == null) edit = true;
      _ref = this.instances;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        i = _ref[_i];
        if (i.number === targetNumber) target = i;
      }
      _ref2 = this.instances;
      for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
        i = _ref2[_j];
        if (i.number === sourceNumber) source = i;
      }
      m = new LSC.Message(name, source, target, location, this);
      _ref3 = this.messages;
      for (_k = 0, _len3 = _ref3.length; _k < _len3; _k++) {
        msg = _ref3[_k];
        if (msg.location >= location) msg.location += 1;
      }
      if (this.lineloc >= location) this.lineloc += 1;
      if (location <= this.resloc) this.resloc += 1;
      this.messages.push(m);
      this.locations = this.locations + 1;
      this.update();
      if (edit) m.edit();
      return m;
    };

    Chart.prototype.createInstance = function(env) {
      var i;
      i = new LSC.Instance("New instance", this.instances.length, env, this.paper, this);
      this.instances.push(i);
      this.update();
      return i.edit();
    };

    Chart.prototype.numberX = function(number) {
      var offset;
      offset = cfg.prechart.padding + cfg.margin + cfg.instance.width / 2;
      return this.x + offset + (number * cfg.instance.width);
    };

    Chart.prototype.xNumber = function(x) {
      var n, offset;
      offset = cfg.prechart.padding + cfg.margin + cfg.instance.width / 2;
      n = Math.round((x - this.x - offset) / cfg.instance.width);
      if (n < 0) n = 0;
      if (n >= this.instances.length) n = this.instances.length - 1;
      return n;
    };

    Chart.prototype.locationY = function(location) {
      return this.y + 2 * cfg.margin + cfg.instance.head.height + cfg.location.height * location;
    };

    Chart.prototype.GetLocation = function(y) {
      var loc;
      loc = Math.round((y - this.y - 2 * cfg.margin - cfg.instance.head.height) / cfg.location.height);
      if (loc < 1) loc = 1;
      if (loc >= this.locations) loc = this.locations - 1;
      return loc;
    };

    Chart.prototype.moveMessage = function(message, location) {
      var m, prev, _i, _j, _len, _len2, _ref, _ref2;
      prev = message.location;
      if (prev < location) {
        _ref = this.messages;
        for (_i = 0, _len = _ref.length; _i < _len; _i++) {
          m = _ref[_i];
          if (prev <= m.location && m.location <= location) m.location -= 1;
        }
        if (prev <= this.lineloc && this.lineloc <= location) this.lineloc -= 1;
        if (prev <= this.resloc && this.resloc <= location) this.resloc -= 1;
      }
      if (prev > location) {
        _ref2 = this.messages;
        for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
          m = _ref2[_j];
          if (location <= m.location && m.location <= prev) m.location += 1;
        }
        if (location <= this.lineloc && this.lineloc <= prev) this.lineloc += 1;
        if (location <= this.resloc && this.resloc <= prev) this.resloc += 1;
      }
      message.location = location;
      return this.update();
    };

    Chart.prototype.clearSelection = function(e) {
      var deselected, i, m, _i, _j, _len, _len2, _ref, _ref2;
      deselected = false;
      _ref = this.messages;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        m = _ref[_i];
        if (!m.selected) continue;
        m.unselect();
        deselected = true;
      }
      _ref2 = this.instances;
      for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
        i = _ref2[_j];
        if (!i.selected) continue;
        i.unselect();
        deselected = true;
      }
      if (deselected) {
        return e != null ? typeof e.stopPropagation === "function" ? e.stopPropagation() : void 0 : void 0;
      }
    };

    Chart.prototype.deleteMessage = function(m) {
      var msg, _i, _len, _ref;
      _ref = this.messages;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        msg = _ref[_i];
        if (msg.location > m.location) msg.location -= 1;
      }
      this.messages = (function() {
        var _j, _len2, _ref2, _results;
        _ref2 = this.messages;
        _results = [];
        for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
          msg = _ref2[_j];
          if (msg !== m) _results.push(msg);
        }
        return _results;
      }).call(this);
      m.remove();
      if (m.location < this.lineloc) this.lineloc -= 1;
      this.resloc -= 1;
      this.locations -= 1;
      return delete m;
    };

    Chart.prototype.deleteInstance = function(i) {
      var inst, m, _i, _j, _len, _len2, _ref, _ref2;
      _ref = this.instances;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        inst = _ref[_i];
        if (inst.number > i.number) inst.number -= 1;
      }
      this.instances = (function() {
        var _j, _len2, _ref2, _results;
        _ref2 = this.instances;
        _results = [];
        for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
          inst = _ref2[_j];
          if (inst !== i) _results.push(inst);
        }
        return _results;
      }).call(this);
      i.remove();
      _ref2 = this.messages;
      for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
        m = _ref2[_j];
        if (m.source === i || m.target === i) this.deleteMessage(m);
      }
      return delete i;
    };

    Chart.prototype.deleteSelection = function() {
      var i, m, _i, _j, _len, _len2, _ref, _ref2;
      _ref = this.messages;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        m = _ref[_i];
        if (m.selected) this.deleteMessage(m);
      }
      _ref2 = this.instances;
      for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
        i = _ref2[_j];
        if (i.selected) this.deleteInstance(i);
      }
      return this.update();
    };

    Chart.prototype.getInstanceByName = function(instanceName) {
      var i, _i, _len, _ref;
      _ref = this.instances;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        i = _ref[_i];
        if (i.name === instanceName) return i;
      }
      return null;
    };

    Chart.prototype.toJSON = function() {
      var i, m;
      return {
        name: LSC.escapeName(this.name),
        lineloc: this.lineloc,
        resloc: this.resloc,
        locations: this.locations,
        instances: (function() {
          var _i, _len, _ref, _results;
          _ref = this.instances;
          _results = [];
          for (_i = 0, _len = _ref.length; _i < _len; _i++) {
            i = _ref[_i];
            _results.push(i.toJSON());
          }
          return _results;
        }).call(this),
        messages: (function() {
          var _i, _len, _ref, _results;
          _ref = this.messages;
          _results = [];
          for (_i = 0, _len = _ref.length; _i < _len; _i++) {
            m = _ref[_i];
            _results.push(m.toJSON());
          }
          return _results;
        }).call(this)
      };
    };

    Chart.emptyJSON = {
      name: "Untitled Chart",
      lineloc: 1,
      resloc: 2,
      locations: 3,
      instances: [],
      messages: []
    };

    Chart.prototype.fromJSON = function(json) {
      var i, inst, msg, source, target, _i, _j, _k, _len, _len2, _len3, _ref, _ref2, _ref3;
      this.name = LSC.unescapeName(json.name);
      this.lineloc = json.lineloc;
      this.resloc = json.resloc;
      this.locations = json.locations;
      _ref = json.instances;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        inst = _ref[_i];
        this.instances.push(new LSC.Instance(LSC.unescapeName(inst.name), inst.number, inst.env, this.paper, this));
      }
      _ref2 = json.messages;
      for (_j = 0, _len2 = _ref2.length; _j < _len2; _j++) {
        msg = _ref2[_j];
        _ref3 = this.instances;
        for (_k = 0, _len3 = _ref3.length; _k < _len3; _k++) {
          i = _ref3[_k];
          if (i.name === msg.source) source = i;
          if (i.name === msg.target) target = i;
        }
        this.messages.push(new LSC.Message(LSC.unescapeName(msg.name), LSC.unescapeName(source), LSC.unescapeName(target), msg.location, this));
      }
      return this.update(true);
    };

    Chart.prototype.serialize = function() {
      return $.toJSON(this.toJSON());
    };

    Chart.prototype.deserialize = function(data) {
      return this.fromJSON($.secureEvalJSON(data));
    };

    return Chart;

  })();

}).call(this);
